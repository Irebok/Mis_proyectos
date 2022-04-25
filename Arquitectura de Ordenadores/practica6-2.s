.data
MSJ: .ascii "Texto a cifrar!."
MSJC: .space MSJC-MSJ
MSJD: .space 1

.text
mov r0,#'c'
ldr r5,=MSJ
ldr r6,=MSJC

bucle: ldrb r1,[r5]
eor r1,r0
strb r1,[r6]

ldrb r2,[r5]
cmp r2,#'.'
beq continuara
add r5,#1
add r6,#1
b bucle

continuara: 

ldr r5,=MSJC
ldr r6,=MSJD

bucle2: ldrb r1,[r5]
eor r1,r0
strb r1,[r6]

cmp r1,#'.'
beq fin
add r5,#1
add r6,#1
b bucle2

fin: wfi
