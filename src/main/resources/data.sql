CREATE TABLE IF NOT EXISTS Run (
    id INT NOT NULL,
    title VARCHAR(250) NOT NULL,
    start_time TIMESTAMP NOT NULL,
    completed_on TIMESTAMP NOT NULL,
    miles INT NOT NULL,
    location VARCHAR(10) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO Run (id, title, start_time, completed_on, miles, location)
VALUES (1, 'Morning Run', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 5, 'INDOOR');