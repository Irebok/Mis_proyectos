 .data    
mul5:  .space 4
Tabla: .word -12, 5, 241, -25, 63, 75, -85, 0 

.text
ldr r0,=Tabla
mov r2,#5
mov r6,#1


BUC:	
ldr r1,[r0]

cmp r1,#0
beq FIN
blt NEG

mov r3,#0



SIGUE:
add r3,r2

cmp r1,r3
beq igual

cmp r1,r3
blt menor

b SIGUE

igual: 
add r4,#1
add r0,#4
b BUC

menor: 
add r0,#4
b BUC

NEG:
mvn r1,r1
add r1,r1,r6

SIGUE2:
add r3,r2

cmp r1,r3
beq igual

cmp r1,r3
blt menor

b SIGUE2





FIN:
ldr r5,=mul5
str r4,[r5]
wfi
