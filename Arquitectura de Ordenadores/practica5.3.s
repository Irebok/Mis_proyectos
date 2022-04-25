 .data 
frase: .ascii "Juan, Pedro y Adela son hermanos; y TRILLIZOS!!!."
cambio: .space 1

.text
ldr r0,=frase
ldr r3,=cambio
mov r2,#32

bucle:
ldrb r1,[r0]
cmp r1,#46
beq fin

cmp r1,#97
bge mayor

cmp r1,#90
ble menor

b sigue

mayor:
cmp r1,#122
ble minus
b sigue

menor:
cmp r1,#65
bge mayus
b sigue


mayus:
add r1,r2
b sigue

minus:
bic r1,r2
b sigue

sigue:
strb r1,[r3]
add r0,#1
add r3,#1
b bucle

fin:
strb r1,[r3]
wfi
