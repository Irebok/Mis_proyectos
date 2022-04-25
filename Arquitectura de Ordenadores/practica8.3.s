.text
mov r0, #5
bl fact
wfi

fact:
cmp r0,#0
beq fact_fin
push {lr}