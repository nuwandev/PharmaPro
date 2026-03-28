-- V1_1__seed_test_data.sql
-- Seed data for testing with password hashing

-- =========================
-- USERS
-- =========================
INSERT INTO users (username, full_name, email, password_hash, role)
VALUES ('admin', 'System Administrator', 'admin@pharmapro.local',
        'admin', 'Admin'),
       ('pharma1', 'John Pharmacist', 'john@pharma.com',
        'pass123', 'Pharmacist'),
       ('cashier1', 'Jane Cashier', 'jane@pharma.com',
        'pass123', 'Cashier');

-- =========================
-- CATEGORIES
-- =========================
INSERT INTO categories (name, description)
VALUES ('Pain Relief', 'Analgesics and pain management'),
       ('Antibiotics', 'Bacterial infection treatment'),
       ('Vitamins', 'Supplements and vitamins'),
       ('Allergy', 'Anti-allergy medication');

-- =========================
-- SUPPLIERS
-- =========================
INSERT INTO suppliers (name, phone, email, address, is_preferred)
VALUES ('ABC Pharma Ltd', '0771234567', 'contact@abcpharma.com', 'Colombo', true),
       ('MediSupply Co', '0779876543', 'sales@medisupply.com', 'Kandy', false);

-- =========================
-- MEDICINES
-- =========================
INSERT INTO medicines
(name, brand, category_id, unit, barcode, default_purchase_price, default_sell_price, tax_rate)
VALUES ('Paracetamol 500mg', 'Panadol', 1, 'Tablet', '111111', 2.00, 3.50, 5),
       ('Amoxicillin 250mg', 'Amoxil', 2, 'Capsule', '222222', 5.00, 8.00, 5),
       ('Vitamin C 1000mg', 'Ceevit', 3, 'Tablet', '333333', 10.00, 15.00, 0),
       ('Cetirizine 10mg', 'Zyrtec', 4, 'Tablet', '444444', 3.00, 6.00, 5);

-- =========================
-- BATCHES
-- =========================
INSERT INTO batches
(medicine_id, batch_number, quantity_on_hand, purchase_price, sell_price, expiry_date, supplier_id)
VALUES (1, 'BATCH-PARA-001', 500, 2.00, 3.50, '2027-12-31', 1),
       (2, 'BATCH-AMOX-001', 200, 5.00, 8.00, '2026-10-01', 1),
       (3, 'BATCH-VITC-001', 150, 10.00, 15.00, '2028-01-01', 2),
       (4, 'BATCH-CET-001', 300, 3.00, 6.00, '2027-05-01', 2);

-- =========================
-- CUSTOMERS
-- =========================
INSERT INTO customers (name, phone)
VALUES ('Walk-in Customer', '0000000000'),
       ('Nimal Perera', '0712345678');

-- =========================
-- SALES
-- =========================
INSERT INTO sales
(sale_number, customer_id, user_id, subtotal, tax_amount, grand_total, payment_method)
VALUES ('SALE-001', 1, 3, 10.50, 0.53, 11.03, 'Cash');

-- =========================
-- SALE ITEMS
-- =========================
INSERT INTO sale_items
    (sale_id, medicine_id, batch_id, quantity, unit_price, line_total)
VALUES (1, 1, 1, 3, 3.50, 10.50);

-- =========================
-- STOCK MOVEMENTS
-- =========================
INSERT INTO stock_movements
(batch_id, movement_type, qty_delta, unit_cost, ref_type, ref_id, created_by)
VALUES (1, 'SALE', -3, 2.00, 'SALE', 1, 3);

-- =========================
-- SETTINGS
-- =========================
INSERT INTO settings (key, value)
VALUES ('store_name', 'PharmaPro Pharmacy'),
       ('currency', 'LKR'),
       ('tax_enabled', 'true');