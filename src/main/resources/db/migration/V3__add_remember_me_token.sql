-- Migration: Add remember_me_token to users table
ALTER TABLE users
    ADD COLUMN remember_me_token TEXT;

