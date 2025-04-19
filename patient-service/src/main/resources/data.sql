/*
-- Ensure the 'patient' table exists
CREATE TABLE IF NOT EXISTS patient
(
    id              UUID PRIMARY KEY,
    name            VARCHAR(255)        NOT NULL,
    email           VARCHAR(255) UNIQUE NOT NULL,
    address         VARCHAR(255)        NOT NULL,
    date_of_birth   DATE,
    register_date   DATE
);

-- Insert well-known UUIDs for specific patients
INSERT INTO patient (id, name, email, address, date_of_birth, register_date)
SELECT '550e8400-e29b-41d4-a716-446655440001', 'Amit Sharma', 'amit.sharma@example.com', 'Kathmandu, Nepal', '1995-08-12', '2025-01-04'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '550e8400-e29b-41d4-a716-446655440001');

INSERT INTO patient (id, name, email, address, date_of_birth, register_date)
SELECT '550e8400-e29b-41d4-a716-446655440002', 'Priya Singh', 'priya.singh@example.com', 'Pokhara, Nepal', '1998-05-22', '2025-01-19'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '550e8400-e29b-41d4-a716-446655440002');

INSERT INTO patient (id, name, email, address, date_of_birth, register_date)
SELECT '550e8400-e29b-41d4-a716-446655440003', 'Rahul Verma', 'rahul.verma@example.com', 'Lalitpur, Nepal', '1990-11-03', '2025-05-04'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '550e8400-e29b-41d4-a716-446655440003');

INSERT INTO patient (id, name, email, address, date_of_birth, register_date)
SELECT '550e8400-e29b-41d4-a716-446655440004', 'Anjali Gupta', 'anjali.gupta@example.com', 'Bhaktapur, Nepal', '2000-01-15', '2025-03-14'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '550e8400-e29b-41d4-a716-446655440004');

INSERT INTO patient (id, name, email, address, date_of_birth, register_date)
SELECT '550e8400-e29b-41d4-a716-446655440005', 'Deepak Thapa', 'deepak.thapa@example.com', 'Butwal, Nepal', '1993-07-19', '2025-02-04'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '550e8400-e29b-41d4-a716-446655440005');*/
