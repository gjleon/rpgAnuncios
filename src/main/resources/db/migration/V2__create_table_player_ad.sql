CREATE TABLE player_ad (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    player_name VARCHAR(255) NOT NULL,
    player_age VARCHAR(255) NOT NULL,
    player_count INT,
    experience VARCHAR(255),
    system_name VARCHAR(255) NOT NULL,
    table_genres VARCHAR(255),
    available_date_time VARCHAR(255),
    accepts_paid_table BOOLEAN,
    platform VARCHAR(255),
    additional_info VARCHAR(255),
    user_account_id BIGINT,
    CONSTRAINT fk_player_ad_user_account
        FOREIGN KEY (user_account_id)
        REFERENCES user_accounts(id)
) engine=InnoDB