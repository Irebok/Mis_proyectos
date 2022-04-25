.data
NBCD: .word 0x12345678 
NUM: .space 4


.text
mov r0,#0
mov r4,#8
mov r2,#0 
mov r1,#8

ldr r5,=NBCD
ldr r5,[r5]

bucle:
mov r3,r5
lsr r3,#28
cmp r3,#9
bgt error
mul r2,r1
add r2,r3

cmp r4,#1
beq fin
sub r4,#1
lsl r5,#4

b bucle



error: mov r0,#1
wfi

fin: 
ldr r1,=NUM
str r2,[r1]
wfi

