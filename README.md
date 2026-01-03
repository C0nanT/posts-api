# 🚀 API Java na AWS

Projeto de **API em Java** desenvolvida com **Spring Boot** e hospedada na **AWS**, simulando um cenário real de produção.

Após estudar Java e AWS, o objetivo foi sair do teórico e entender **como uma aplicação realmente roda na nuvem**, com foco em rede, segurança e integração entre serviços.

## 🛠️ Stack
- Java + Spring Boot
- PostgreSQL
- AWS (EC2, VPC, S3)

## ☁️ Arquitetura na AWS
- **VPC dedicada**, com isolamento de rede
- **Subnet pública**
  - EC2 rodando a API
  - Internet Gateway
- **Subnet privada**
  - Banco de dados PostgreSQL
- **Amazon S3**
  - Armazenamento de imagens enviadas pela API

## 🔄 Fluxo da aplicação
1. Usuário acessa a API  
2. Requisição chega na EC2  
3. Imagens são armazenadas no S3  
4. API se comunica com o banco na subnet privada  

## 🎯 Objetivo do projeto
Não é um projeto grande, mas foi essencial para consolidar conceitos como:
- Comunicação entre subnets públicas e privadas  
- Integração entre EC2, banco de dados e S3  
- Estrutura básica de uma arquitetura segura e organizada na AWS  

## 🖼️ Arquitetura e prints

<img src="https://github.com/user-attachments/assets/e600a093-c6b5-4a37-8ce4-b96c34226955" width="800" />
<img src="https://github.com/user-attachments/assets/1bf50e27-a039-4cdf-8fa3-4f0a4cdd4cf6" width="600" />
<img src="https://github.com/user-attachments/assets/2f6074b7-ea3c-4cd8-919a-05be52a7cd4c" width="800" />

