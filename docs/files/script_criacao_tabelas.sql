CREATE TABLE "cao"
(
    "id"              bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    "nome"            text NOT NULL,
    "cor"             text NOT NULL,
    "data_nascimento" date NOT NULL,
    "sexo"            text NOT NULL,
    "created_at"      timestamp DEFAULT (now()),
    "updated_at"      timestamp DEFAULT (now())
);

CREATE TABLE "plano_ensino"
(
    "id_cao"    bigint PRIMARY KEY,
    "descricao" text
);

CREATE TABLE "tutor_cao"
(
    "id"                    BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    "id_cao"                bigint      NOT NULL,
    "id_usuario"            bigint      NOT NULL,
    "id_situacao_tutor_cao" smallserial NOT NULL,
    "created_at"            timestamp DEFAULT (now()),
    "updated_at"            timestamp DEFAULT (now())
);

CREATE TABLE "situacao_tutor_cao"
(
    "id"        smallserial PRIMARY KEY,
    "descricao" text NOT NULL
);

CREATE TABLE "evento"
(
    "id"              BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    "titulo"          text        NOT NULL,
    "descricao"       text        NOT NULL,
    "data"            timestamp   NOT NULL,
    "notificar_tutor" boolean     NOT NULL,
    "id_cao"          smallserial NOT NULL,
    "created_at"      timestamp DEFAULT (now()),
    "updated_at"      timestamp DEFAULT (now())
);

CREATE TABLE "pessoa"
(
    "id"               BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    "nome"             text          NOT NULL,
    "data_nascimento"  date          NOT NULL,
    "cpf"              character(11) NOT NULL,
    "telefone_celular" text          NOT NULL,
    "telefone_fixo"    text,
    "created_at"       timestamp DEFAULT (now()),
    "updated_at"       timestamp DEFAULT (now())
);


CREATE TABLE "usuario"
(
    "id"             BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    "id_pessoa"      BIGINT              NOT NULL UNIQUE,
    "email"            text          NOT NULL, -- create unique index below
    "password"         text          NOT NULL,
    "ativo"            boolean       NOT NULL DEFAULT TRUE,
    "created_at"       timestamp              DEFAULT (now()),
    "updated_at"       timestamp              DEFAULT (now()),
    FOREIGN KEY ("id_pessoa") REFERENCES "pessoa" ("id")
);


CREATE TYPE "enum_grau_instrucao" AS ENUM (
    'nao_alfabetizado',
    'ensino_fundamental_incompleto',
    'ensino_fundamental_completo',
    'ensino_medio_incompleto',
    'ensino_medio_completo',
    'graduacao_incompleta',
    'graducao_completa',
    'pos_graduacao',
    'mestrado_ou_doutorado_incompleto',
    'mestrado_ou_douturado_completo'
    );

CREATE TYPE "enum_estado_civil" AS ENUM (
    'solteiro',
    'uniao_estavel',
    'casado',
    'divorciado',
    'viuvo'
    );

CREATE CAST (varchar AS enum_grau_instrucao) WITH INOUT AS IMPLICIT;
CREATE CAST (varchar AS enum_estado_civil) WITH INOUT AS IMPLICIT;

CREATE TABLE "socializador"
(
    "id"             BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    "id_pessoa"      BIGINT            NOT NULL UNIQUE,
    "email"          text              NOT NULL,
    "rg"             text              NOT NULL,
    "orgao_emissor"  text              NOT NULL,
    "endereco"       text              NOT NULL,
    "grau_instrucao" enum_grau_instrucao NOT NULL,
    "profissao"      text              NOT NULL,
    "local_trabalho" text              NOT NULL,
    "estuda"         boolean           NOT NULL,
    "local_estudo"   text              NOT NULL,
    "estado_civil"   enum_estado_civil NOT NULL,
    FOREIGN KEY ("id_pessoa") REFERENCES "pessoa" ("id")
);

create table estado (
     id int generated by default as identity primary key,
     nome text not null,
     sigla text not null
);

create table cidade (
     id int generated by default as identity primary key,
     nome text not null,
     id_estado int not null,
     foreign key ("id_estado") references "estado" ("id")
);

create table endereco (
     cep int not null primary key,
     logradouro text not null,
     numero text,
     bairro text not null,
     id_cidade int not null,
     id_estado int not null,
     foreign key ("id_cidade") references "cidade" ("id"),
     foreign key ("id_estado") references "estado" ("id")
);

CREATE TABLE "atualizacoes_cao" (
  "id" BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "email" text NOT NULL,
  "nome" text NOT NULL,
  "endereco" text NOT NULL,
  "telefone" text NOT NULL,
  "nome_contato_recado" text NOT NULL,
  "telefone_contato_recado" text NOT NULL,
  "situacao_cao" text NOT NULL,
  "antiparasitario_interno_data" date NOT NULL,
  "antiparasitario_externo_data" date NOT NULL,
  "troca_coleira_scalibor_data" date NOT NULL,
  "tem_caderneta_vacinacao" text NOT NULL,
  "ultima_vacina_nobivac_dhppi_l" date NOT NULL,
  "ultima_vacina_nobivac_raiva" date NOT NULL,
  "tem_bloco_veterinario" text NOT NULL,
  "tem_carteirinha_socializador" text NOT NULL,
  "nome_cao" text, 
  "created_at" timestamp DEFAULT (now())
);

-- CREATE TABLE "perfil" (
--   "id" smallserial GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
--   "nome" text NOT NULL,
--   "descricao" text NOT NULL,
--   "created_at" timestamp DEFAULT (now()),
--   "updated_at" timestamp DEFAULT (now())
-- );

-- CREATE TABLE "perfil_usuario" (
--   "id_usuario" bigint,
--   "id_perfil" int,
--   PRIMARY KEY ("id_usuario", "id_perfil")
-- );

-- CREATE TABLE "permissao" (
--   "id" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
--   "nome" text NOT NULL,
--   "descricao" text NOT NULL,
--   "created_at" timestamp DEFAULT (now()),
--   "updated_at" timestamp DEFAULT (now())
-- );

-- CREATE TABLE "permissao_perfil" (
--   "id_perfil" int,
--   "id_permissao" int,
--   PRIMARY KEY ("id_perfil", "id_permissao")
-- );

COMMENT ON
    TABLE "tutor_cao"
    IS 'Estrutura para de relação entre um usuário e um cao. Esta relação possui uma situação ativa ou inativa, sendo que poderá existir somente uma relação ativa por vez entre cao e usuário.';

COMMENT ON TABLE "situacao_tutor_cao" IS 'Representa a situação atual da relação do tutor com o cão, podendo esta relação estar ativa ou inativa.';

COMMENT ON TABLE "evento" IS 'O campo "data" representa qual a data do evento, devendo o próprio usuário informá-la. Quando for exibido em formato de notificação para o tutor, basta buscar os eventos >= data atual. Quando for exibido em histórico basta buscar todos os eventos.';

COMMENT ON TABLE "usuario" IS 'Email e cpf poderão ser utilizados como login, pois são chaves únicas.';

ALTER TABLE "plano_ensino"
    ADD FOREIGN KEY ("id_cao") REFERENCES "cao" ("id");

ALTER TABLE "tutor_cao"
    ADD FOREIGN KEY ("id_cao") REFERENCES "cao" ("id");

ALTER TABLE "tutor_cao"
    ADD FOREIGN KEY ("id_usuario") REFERENCES "usuario" ("id");

ALTER TABLE "tutor_cao"
    ADD FOREIGN KEY ("id_situacao_tutor_cao") REFERENCES "situacao_tutor_cao" ("id");

ALTER TABLE "evento"
    ADD FOREIGN KEY ("id_cao") REFERENCES "cao" ("id");

CREATE UNIQUE INDEX unique_email_on_usuario ON usuario (lower(email));
CREATE UNIQUE INDEX unique_cpf_on_usuario ON pessoa (cpf);

-- ALTER TABLE "perfil_usuario" ADD FOREIGN KEY ("id_usuario") REFERENCES "usuario" ("id");

-- ALTER TABLE "perfil_usuario" ADD FOREIGN KEY ("id_perfil") REFERENCES "perfil" ("id");

-- ALTER TABLE "permissao_perfil" ADD FOREIGN KEY ("id_perfil") REFERENCES "perfil" ("id");

-- ALTER TABLE "permissao_perfil" ADD FOREIGN KEY ("id_permissao") REFERENCES "permissao" ("id");

-- Cargas iniciais
insert into situacao_tutor_cao(descricao) values ('Ativo');
insert into situacao_tutor_cao(descricao) values ('Inativo');

-- Primeiro, certifique-se de que o módulo pgcrypto esteja disponível
CREATE EXTENSION IF NOT EXISTS pgcrypto;

-- Agora, insira o usuário com senha criptografada
do $$
    declare
        id_pessoa_administrador pessoa.id%TYPE;
    begin
        INSERT INTO "pessoa" (
            "nome",
            "cpf",
            "data_nascimento",
            "telefone_celular"
        )
        VALUES (
           'Administrador',
           '12345678901',
           '2000-01-01',
           '(11) 98765-4321'
       ) returning id into id_pessoa_administrador;

        INSERT INTO "usuario" (id_pessoa, email, password)
        VALUES (id_pessoa_administrador, 'admin@example.com', crypt('senha123', gen_salt('bf')));
    end $$

-- Para logar no sistema, utilizar o login "admin@example.com" e senha "senha123"

