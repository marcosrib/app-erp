#!/bin/bash

# Verifica se um argumento foi passado para a descrição
if [ -z "$1" ]; then
    echo "Por favor, forneça uma descrição para o arquivo de migração."
    exit 1
fi

# Obter data/hora atual
timestamp=$(date +'%Y%m%d%H%M%S')

# Nome do arquivo de migração com base na descrição e no timestamp
migration_file="V${timestamp}__${1// /_}.sql"  # Substitui espaços por underscores na descrição

# Criar arquivo de migração
touch "src/main/resources/db/migration/sql/$migration_file"

echo "Arquivo de migração gerado: $migration_file"