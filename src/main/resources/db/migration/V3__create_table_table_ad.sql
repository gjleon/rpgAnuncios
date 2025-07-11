CREATE TABLE table_ad (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    campaign_name VARCHAR(255) NOT NULL,
    system_name VARCHAR(255) NOT NULL,
    table_genres VARCHAR(255) NOT NULL,
    scheduled_date_time VARCHAR(255) NOT NULL,
    synopsis TEXT NOT NULL,
    max_slots INT NOT NULL,
    filled_slots INT NOT NULL,
    is_paid_table BOOLEAN,
    table_rules TEXT,
    table_price VARCHAR(255),
    platform VARCHAR(255),
    form_link VARCHAR(255),
    media_url VARCHAR(255),
    additional_info TEXT,
    user_account_id BIGINT,
    CONSTRAINT fk_table_ad_user_account
        FOREIGN KEY (user_account_id)
        REFERENCES user_accounts(id)
) engine=InnoDB