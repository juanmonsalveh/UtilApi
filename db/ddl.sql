-- we don't know how to generate schema bank_db (class Schema) :(
CREATE TABLE user_bank
(
  id          INT          NOT NULL
    PRIMARY KEY,
  user_name   VARCHAR(255) NULL,
  user_email  VARCHAR(255) NULL,
  user_pwd    VARCHAR(255) NULL,
  is_employee TINYINT(1)   NULL,
  username    VARCHAR(255) NULL
);

CREATE TABLE account (
  id       INT          NOT NULL
    PRIMARY KEY,
  balance  VARCHAR(255) NULL,
  owner_id VARCHAR(255) NOT NULL,
  FOREIGN KEY (owner_id) REFERENCES user_bank (id)
);

CREATE TABLE otp (
  otp_code  INT          NOT NULL
    PRIMARY KEY,
  owner     VARCHAR(255) NOT NULL,
  FOREIGN KEY (owner) REFERENCES user_bank (id),
  is_active TINYINT(1)   NULL
);

CREATE TABLE transactions (
  id                  INT          NOT NULL PRIMARY KEY,
  origin_account      VARCHAR(255) NOT NULL,
  FOREIGN KEY (origin_account) REFERENCES account (id),
  destination_account VARCHAR(255) NOT NULL,
  FOREIGN KEY (destination_account) REFERENCES account (id),
  amount              INTEGER      NOT NULL,
  otp_code            VARCHAR(255) NOT NULL,
  FOREIGN KEY (otp_code) REFERENCES otp (otp_code),
  date                TIMESTAMP    NOT NULL
);