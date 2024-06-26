CREATE TABLE Coleta (
    coleta_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name_item VARCHAR(255),
    qnt_item INT,
    material VARCHAR(255)
);
CREATE TABLE Agendamento (
    agendamento_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    endereco VARCHAR(255),
    cliente VARCHAR(255),
    data DATE,
    status VARCHAR(255)
);
