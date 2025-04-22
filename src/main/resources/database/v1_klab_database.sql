CREATE TABLE PRODUTO (
                         idProduto INTEGER
                             GENERATED ALWAYS AS IDENTITY
                             PRIMARY KEY,
                         descricao VARCHAR(50),
                         preco DECIMAL(10,2)
)

CREATE TABLE DEPARTAMENTO (
                              idDepartamento INTEGER
                                  GENERATED ALWAYS AS IDENTITY
                                  PRIMARY KEY,
                              descricao VARCHAR(50)
)

CREATE TABLE PEDIDO (
                        idPedido INTEGER
                            GENERATED ALWAYS AS IDENTITY
                            PRIMARY KEY,
                        dataPedido DATE
)

CREATE TABLE PEDIDOPRODUTO (
                               idPedido INTEGER,
                               idProduto INTEGER,
                               quantidade INTEGER,
                               preco DECIMAL(10,2),
                               PRIMARY KEY (idPedido, idProduto),
                               FOREIGN KEY (idProduto) REFERENCES PRODUTO(idProduto),
                               FOREIGN KEY (idPedido) REFERENCES PEDIDO(idPedido)
)