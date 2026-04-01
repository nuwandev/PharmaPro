package com.nuwandev.pharmapro.repository;

import com.nuwandev.pharmapro.database.DatabaseContext;
import com.nuwandev.pharmapro.enums.MedicineStatus;
import com.nuwandev.pharmapro.model.Medicine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MedicineRepository {
    public List<Medicine> search(String query) throws SQLException {
        String sql = "SELECT * FROM medicines WHERE name ILIKE ? OR brand ILIKE ? OR barcode ILIKE ? ORDER BY name ASC";
        try (Connection conn = DatabaseContext.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            String q = "%" + query + "%";
            ps.setString(1, q);
            ps.setString(2, q);
            ps.setString(3, q);
            ResultSet rs = ps.executeQuery();
            List<Medicine> result = new ArrayList<>();
            while (rs.next()) {
                result.add(mapRow(rs));
            }
            return result;
        }
    }

    public List<Medicine> findAll() throws SQLException {
        String sql = "SELECT * FROM medicines ORDER BY name ASC";
        try (Connection conn = DatabaseContext.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<Medicine> result = new ArrayList<>();
            while (rs.next()) {
                result.add(mapRow(rs));
            }
            return result;
        }
    }

    public Optional<Medicine> findById(Long id) throws SQLException {
        String sql = "SELECT * FROM medicines WHERE id = ?";
        try (Connection conn = DatabaseContext.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(mapRow(rs));
            }
            return Optional.empty();
        }
    }

    public Medicine save(Medicine medicine) throws SQLException {
        String sql = "INSERT INTO medicines (name, brand, category_id, unit, barcode, status, description, default_purchase_price, default_sell_price, reorder_level, tax_rate, requires_prescription, allow_fractional_qty) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING *";
        try (Connection conn = DatabaseContext.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, medicine.name());
            ps.setString(2, medicine.brand());
            ps.setObject(3, medicine.categoryId());
            ps.setString(4, medicine.unit());
            ps.setString(5, medicine.barcode());
            ps.setString(6, medicine.status() != null ? medicine.status().name() : null);
            ps.setString(7, medicine.description());
            ps.setBigDecimal(8, medicine.defaultPurchasePrice());
            ps.setBigDecimal(9, medicine.defaultSellPrice());
            ps.setInt(10, medicine.reorderLevel());
            ps.setBigDecimal(11, medicine.taxRate());
            ps.setBoolean(12, medicine.requiresPrescription());
            ps.setBoolean(13, medicine.allowFractionalQty());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapRow(rs);
            }
            throw new SQLException("Failed to insert medicine");
        }
    }

    public Medicine update(Medicine medicine) throws SQLException {
        String sql = "UPDATE medicines SET name=?, brand=?, category_id=?, unit=?, barcode=?, status=?, description=?, default_purchase_price=?, default_sell_price=?, reorder_level=?, tax_rate=?, requires_prescription=?, allow_fractional_qty=?, updated_at=now() WHERE id=? RETURNING *";
        try (Connection conn = DatabaseContext.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, medicine.name());
            ps.setString(2, medicine.brand());
            ps.setObject(3, medicine.categoryId());
            ps.setString(4, medicine.unit());
            ps.setString(5, medicine.barcode());
            ps.setString(6, medicine.status() != null ? medicine.status().name() : null);
            ps.setString(7, medicine.description());
            ps.setBigDecimal(8, medicine.defaultPurchasePrice());
            ps.setBigDecimal(9, medicine.defaultSellPrice());
            ps.setInt(10, medicine.reorderLevel());
            ps.setBigDecimal(11, medicine.taxRate());
            ps.setBoolean(12, medicine.requiresPrescription());
            ps.setBoolean(13, medicine.allowFractionalQty());
            ps.setLong(14, medicine.id());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapRow(rs);
            }
            throw new SQLException("Failed to update medicine");
        }
    }

    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM medicines WHERE id = ?";
        try (Connection conn = DatabaseContext.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        }
    }

    private Medicine mapRow(ResultSet rs) throws SQLException {
        return new Medicine(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("brand"),
                rs.getObject("category_id", Long.class),
                rs.getString("unit"),
                rs.getString("barcode"),
                MedicineStatus.fromDbValue(rs.getString("status")),
                rs.getString("description"),
                rs.getBigDecimal("default_purchase_price"),
                rs.getBigDecimal("default_sell_price"),
                rs.getInt("reorder_level"),
                rs.getBigDecimal("tax_rate"),
                rs.getBoolean("requires_prescription"),
                rs.getBoolean("allow_fractional_qty"),
                rs.getObject("created_at", java.time.OffsetDateTime.class),
                rs.getObject("updated_at", java.time.OffsetDateTime.class)
        );
    }
}
