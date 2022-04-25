.data
cadena:.asciz "2678"


.text
ldr r0,=cadena
bl asctobin

wfi 


asctobin: mov r3,#10
mov r1,#0

asc_buc: push {r0,r2,r3}
ldrb r2,[r0]
cmp r2,#0
beq asc_fin

sub r2,#48
mul r1,r3
add r1,r2

add r0,#1
b asc_buc


asc_fin: pop {r0,r2,r3}
mov pc,lr 
