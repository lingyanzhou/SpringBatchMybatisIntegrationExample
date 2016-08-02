-- in_table
CREATE TABLE in_table (
  it_id INT AUTO_INCREMENT,
  it_data VARCHAR(30),
  it_irt_id INT,
  PRIMARY KEY (it_id)
);

-- in_related_table
CREATE TABLE in_related_table (
  irt_id INT AUTO_INCREMENT,
  irt_data VARCHAR(30),
  PRIMARY KEY (irt_id)
);

-- out_table
CREATE TABLE out_table (
  ot_id INT AUTO_INCREMENT,
  ot_data VARCHAR(30),
  ot_update_time TIMESTAMP,
  ot_data_2 VARCHAR(30),
  PRIMARY KEY (it_id)
);

