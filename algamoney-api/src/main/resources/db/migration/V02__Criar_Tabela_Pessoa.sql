CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  	nome VARCHAR(45) NOT NULL,
  	ativo TINYINT NOT NULL,
  	logradouro VARCHAR(45) NULL,
  	numero VARCHAR(15) NULL,
  	complemento VARCHAR(45) NULL,
  	bairro VARCHAR(45) NULL,
  	cep VARCHAR(10) NULL,
  	cidade VARCHAR(45) NULL,
  	estado VARCHAR(30) NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

  INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) VALUES ('Rodrigo Rossi',true,'Rua Carajás','2574','Sobrado','Angra dos Reis','85.806-250','Cascavel','Paraná');
  INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) VALUES ('William Meurer',false,'Rua das Amélias','545','','Maria Luiza','85.806-998','Jaguariaíva','Paraná');
  INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) VALUES ('Alexandre Martins',true,'Rua Jacarandá','665','','Santos Domund','85.806-665','Curitiba','Paraná');
  INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) VALUES ('Rubia Antunes',true,'Avenida das Torres','2232','Cancelli','Angra dos Reis','86.998-250','Aroeira','Paraná');
  INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) VALUES ('Afonso dos Reis',false,'Av. Brasil','78','Ap 306','Interlagos','85.806-244','Cuiabá','MT');
  INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) VALUES ('Mestre dos Magos',true,'Rua Araucaria','2254','Apartamento 2','Parque Verde','83.806-112','Marechal Cândido Rondon','Paraná');
  INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) VALUES ('Anderson Silva',true,'Rua São Paulo','986','Sobrado Esquerda','Santa Cruz','85.801-002','Medianeira','Paraná');
  INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) VALUES ('Vitor Belfort',true,'Av. Santos Dumont','332','AB','Coqueiral','85.896-555','Foz do Iguaçu','Paraná');
  INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) VALUES ('Neymar Junior',false,'Rua Vitória','5568','Portao Azul','Cidade Verde','85.545-332','Santo Antônio da Platina','Paraná');
  INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) VALUES ('Ronaldo Fenomeno',true,'Avenida Tancredo Neves','665','Casa','Centro','85.002-221','Maringá','Paraná');