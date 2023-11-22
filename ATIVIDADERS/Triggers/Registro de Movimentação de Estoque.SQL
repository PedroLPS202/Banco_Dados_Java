CREATE DATABASE IF NOT EXISTS TriggersAtividade;

USE TriggersAtividade;

CREATE TABLE IF NOT EXISTS estoque (
    id_item INT PRIMARY KEY AUTO_INCREMENT,
    quantidades INT NOT NULL,
    data_atualizacao DATE
);

CREATE TABLE IF NOT EXISTS historico_estoque (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_item INT NOT NULL,
    antigas_quantidades INT NOT NULL,
    novas_quantidades INT NOT NULL,
    data_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_item) REFERENCES estoque(id_item)
);

DELIMITER //

CREATE TRIGGER after_estoque_insert
AFTER UPDATE ON estoque
FOR EACH ROW
BEGIN
    IF OLD.quantidades <> NEW.quantidades THEN
        INSERT INTO historico_estoque (id_item, antigas_quantidades, novas_quantidades)
        VALUES (OLD.id_item, OLD.quantidades, NEW.quantidades);
    END IF;
END;
//

DELIMITER ;