package com.example.service;

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

    private final static Logger logger = Logger.getLogger(RaceCardService.class.getName());
    private final ConnectionPoolHelper connectionPoolHelper = ConnectionPoolHelper.getInstance();

    @Override
    public List<Integer> getRaceCardIds() {

        List<Integer> raceCardIds = new ArrayList<>();

        try (Connection conn = connectionPoolHelper.getDataSource().getPooledConnection().getConnection()) {
            try (Statement stmnt = conn.createStatement()) {
                ResultSet rs = stmnt.executeQuery("select Id from racecard order by SortOrder");
                while (rs != null && rs.next()) {
                    raceCardIds.add(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            logger.severe(e.getMessage());
        }

        return raceCardIds;
    }

    @Override
    public RaceCard getRaceCard(int raceCardId) {

        RaceCard raceCard = null;

        String sql1 = "select Id, SortOrder, EventDesc from racecard where Id = ?";
        String sql2 = "select Id, HeatNumber from race where RaceCardId = ?";
        String sql3 = "select Lane, StartNumber, FirstName, LastName, Country, SB2017, PB from participant where RaceId = ?";

        try (Connection conn = connectionPoolHelper.getDataSource().getPooledConnection().getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement(sql1)) {
                try (PreparedStatement ps2 = conn.prepareStatement(sql2)) {
                    try (PreparedStatement ps3 = conn.prepareStatement(sql3)) {

                        ps.setInt(1, raceCardId);
                        ResultSet rs = ps.executeQuery();

                        if (rs != null && rs.next()) {

                            raceCard = new RaceCard(rs.getInt(1), rs.getInt(2), rs.getString(3));

                            ps2.setInt(1, raceCard.getId());
                            ResultSet rs2 = ps2.executeQuery();

                            while (rs2 != null && rs2.next()) {

                                Race race = new Race(rs2.getInt(1), rs2.getInt(2));
                                ps3.setInt(1, race.getId());

                                try (ResultSet rs3 = ps3.executeQuery()) {
                                    while (rs3 != null && rs3.next()) {
                                        race.getParticipants().add(new Participant(rs3.getInt(1), rs3.getInt(2), rs3.getString(3), rs3.getString(4), rs3.getString(5), rs3.getDouble(6), rs3.getDouble(7)));
                                    }
                                }

                                raceCard.getRaces().add(race);
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            logger.severe(e.getMessage());
        }

        return raceCard;
    }

    public static RaceCardService getInstance() {
        return INSTANCE;
    }
}
