package com.example.service;

import com.creang.puddle.MiniConnectionPoolManager;
import com.creang.puddle.Util;
import com.example.db.ConnectionPoolHelper;
import com.example.model.Participant;
import com.example.model.Race;
import com.example.model.RaceCard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public enum RaceCardService implements IRaceCardService {
    INSTANCE;

    private final static Logger LOGGER = Logger.getLogger(RaceCardService.class.getName());
    private ConnectionPoolHelper connectionPoolHelper = ConnectionPoolHelper.getInstance();
    private MiniConnectionPoolManager poolManager = connectionPoolHelper.getMiniConnectionPoolManager();
    private List<Integer> raceCardIds = new ArrayList<>();

    @Override
    public List<Integer> getRaceCardIds() {

        raceCardIds.clear();

        Connection conn = null;
        Statement stmnt = null;
        ResultSet rs = null;

        try {
            conn = poolManager.getValidConnection(3);
            stmnt = conn.createStatement();
            rs = stmnt.executeQuery("select Id from racecard order by SortOrder");
            while (rs.next()) {
                raceCardIds.add(rs.getInt("Id"));
            }
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        } finally {
            Util.closeResultSet(rs);
            Util.closeStatement(stmnt);
            poolManager.release(conn);
        }

        return raceCardIds;
    }

    @Override
    public RaceCard getRaceCard(int raceCardId) {

        RaceCard raceCard = null;
        Connection conn = null;
        PreparedStatement prepStmnt = null;
        ResultSet rs = null;

        try {
            conn = poolManager.getValidConnection(3);
            prepStmnt = conn.prepareStatement("select Id, SortOrder, EventDesc from racecard where Id = ?");
            prepStmnt.setInt(1, raceCardId);
            rs = prepStmnt.executeQuery();
            while (rs.next()) {
                raceCard = new RaceCard(rs.getInt("Id"), rs.getInt("SortOrder"), rs.getString("EventDesc"));
            }
            rs.close();
            prepStmnt.close();

            prepStmnt = conn.prepareStatement("select Id, HeatNumber from race where RaceCardId = ?");
            prepStmnt.setInt(1, raceCard.getId());
            rs = prepStmnt.executeQuery();

            while (rs.next()) {
                Race race = new Race(rs.getInt("Id"), rs.getInt("HeatNumber"));
                raceCard.getRaces().add(race);
            }
            rs.close();
            prepStmnt.close();

            prepStmnt = conn.prepareStatement("select Lane, StartNumber, FirstName, LastName, Country, SB2017, PB from participant where RaceId = ?");
            for (Race race : raceCard.getRaces()) {
                prepStmnt.setInt(1, race.getId());
                rs = prepStmnt.executeQuery();
                while (rs.next()) {
                    race.getParticipants().add(createParticipant(rs.getInt("Lane"), rs.getInt("StartNumber"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Country"), rs.getDouble("SB2017"), rs.getDouble("PB")));
                }
            }

        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        } finally {
            Util.closeResultSet(rs);
            Util.closeStatement(prepStmnt);
            poolManager.release(conn);
        }

        return raceCard;
    }

    private Participant createParticipant(int lane, int startNumber, String firstname, String lastname, String country, double sb2017, double pb) {
        Participant participant = new Participant(lane, startNumber, firstname, lastname, country, sb2017, pb);
        return participant;
    }

    public static RaceCardService getInstance() {
        return INSTANCE;
    }
}
