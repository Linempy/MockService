CREATE TABLE exchange_rate (
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE,
    rate_date DATE NOT NULL,
    currency_id VARCHAR(255) NOT NULL,
    num_code VARCHAR(255),
    char_code VARCHAR(255) NOT NULL,
    nominal INTEGER NOT NULL,
    name VARCHAR(255) NOT NULL,
    value_rate DECIMAL(10,4) NOT NULL,
    vunit_rate DECIMAL(10,4)
);


INSERT INTO exchange_rate (
    rate_date, currency_id, num_code, char_code,
    nominal, name, value_rate, vunit_rate
) VALUES
    ('2002-03-02', 'R01010', '036', 'AUD', 1, 'Австралийский доллар', 16.0102, 16.0102),
    ('2002-03-02', 'R01035', '826', 'GBP', 1, 'Фунт стерлингов', 43.8254, 43.8254),
    ('2002-03-02', 'R01090', '974', 'BYR', 1000, 'Белорусских рублей', 18.4290, 0.018429),
    ('2002-03-02', 'R01215', '208', 'DKK', 10, 'Датских крон', 36.1010, 3.6101),
    ('2002-03-02', 'R01235', '840', 'USD', 1, 'Доллар США', 30.9436, 30.9436),
    ('2002-03-02', 'R01239', '978', 'EUR', 1, 'Евро', 26.8343, 26.8343)
