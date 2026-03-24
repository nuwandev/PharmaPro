SET search_path TO pharmapro;

INSERT INTO users (username, full_name, email, password_hash, role, status)
VALUES ('admin',
        'Admin User',
        'admin@pharmapro.com',
           -- bcrypt/argon2 hash in real use
        '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918',
        'Admin',
        'Active')
ON CONFLICT
    (username)
DO NOTHING;

INSERT INTO categories (name)
VALUES ('Antibiotics'),
       ('Analgesics'),
       ('Antacids'),
       ('Antihistamines'),
       ('Antidiabetics'),
       ('Antihypertensives'),
       ('Vitamins & Supplements'),
       ('Cough & Cold'),
       ('Dermatologicals'),
       ('Ophthalmic'),
       ('Ear / Nose / Throat'),
       ('Cardiovascular'),
       ('Gastrointestinal'),
       ('Respiratory'),
       ('Hormonal'),
       ('Vaccines'),
       ('Surgical Supplies'),
       ('Medical Devices'),
       ('Miscellaneous')
ON CONFLICT
    (name)
DO NOTHING;

INSERT INTO reorder_rules (category_id, reorder_level, reorder_qty, alert_method)
VALUES (NULL, 10, 50, 'Dashboard')
ON CONFLICT
    (category_id)
DO NOTHING;

INSERT INTO settings (key, value)
VALUES ('pharmacy_name', 'PharmaPro Pharmacy'),
       ('currency', 'USD'),
       ('date_format', 'MM/dd/yyyy'),
       ('timezone', 'UTC'),
       ('default_tax_rate', '0'),
       ('decimal_places', '2'),
       ('auto_print_receipt', 'false'),
       ('require_prescription', 'false'),
       ('enable_barcode', 'true'),
       ('show_expiring_alert', 'true'),
       ('enable_sound', 'false'),
       ('dark_mode', 'false'),
       ('expiry_warning_days', '30'),
       ('default_reorder_level', '10'),
       ('default_reorder_qty', '50'),
       ('alert_method', 'Dashboard'),
       ('receipt_header', 'PharmaPro Pharmacy'),
       ('receipt_sub_header', 'Your health, our priority'),
       ('receipt_footer', 'Thank you for your purchase! Please keep this receipt.'),
       ('receipt_paper_width', '80mm'),
       ('receipt_show_logo', 'false'),
       ('receipt_show_address', 'true'),
       ('receipt_show_phone', 'true'),
       ('receipt_show_batch', 'true'),
       ('receipt_show_expiry', 'true'),
       ('receipt_show_cashier', 'true'),
       ('receipt_show_barcode', 'false'),
       ('next_sale_number', '1'),
       ('next_po_number', '1')
ON CONFLICT
    (key)
DO NOTHING;