CREATE TABLE IF NOT EXISTS endereco (
  id INT NOT NULL AUTO_INCREMENT,
  cliente_id INT NOT NULL,
  bairro VARCHAR(50) NOT NULL,
  logradouro VARCHAR(50) NOT NULL UNIQUE,
  cep INT NOT NULL,
  numero INT NOT NULL,
  cidade VARCHAR(50),
  uf VARCHAR(2),

  PRIMARY KEY (id),
  FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);