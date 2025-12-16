# ADR-001: Transactional Outbox Pattern

## Status
Accepted

## Context
O projeto Transactional Resilience tem como objetivo lidar com problemas comuns em sistemas distribuídos,
especialmente em fluxos críticos como pagamentos e integrações assíncronas.

Um dos principais desafios é garantir consistência entre a persistência de dados em banco
e a publicação de eventos, considerando cenários como:
- falhas parciais
- timeouts
- retries automáticos
- indisponibilidade temporária da mensageria

Publicar eventos diretamente após a persistência pode gerar inconsistência caso ocorra falha
entre essas etapas.

## Decision
Adotar o padrão **Transactional Outbox** como mecanismo principal para garantir consistência
entre o banco de dados e a publicação de eventos.

Os eventos de domínio serão persistidos em uma tabela de outbox
na mesma transação do aggregate principal.
A publicação para o broker será realizada de forma assíncrona por um processo dedicado.

## Consequences
### Positive
- Garante consistência transacional entre dados e eventos
- Evita perda de eventos em caso de falhas
- Permite reprocessamento e replay de eventos
- Facilita auditoria e troubleshooting

### Negative
- Introduz atraso entre persistência e publicação do evento
- Requer processo adicional para publicação (scheduler / worker)
- Aumenta a complexidade operacional

## Notes
Outras abordagens, como publicação direta ou CDC, foram consideradas,
mas o Transactional Outbox foi escolhido por sua previsibilidade,
simplicidade de implementação e adequação ao escopo inicial do projeto.
