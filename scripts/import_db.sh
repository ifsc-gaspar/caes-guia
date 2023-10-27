#!/bin/bash
export PGPASSWORD=postgres
psql -h db -U postgres -d escola-caes-guia -a -f /caes-guia/scripts/script_criacao_tabelas.sql
psql -h db -U postgres -d escola-caes-guia -a -f /caes-guia/scripts/insert_estado.sql
psql -h db -U postgres -d escola-caes-guia -a -f /caes-guia/scripts/insert_cidade.sql
psql -h db -U postgres -d escola-caes-guia -a -f /caes-guia/scripts/insert_endereco.sql
