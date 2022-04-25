.data
DATO: .hword 0xF0F1

.text
ldr r6,=DATO
ldrh r1,[r6]
mov r0,#0

bucle:
lsr r1,r1,#1
bcc cero
add r0,#1

cero:
cmp r1,#0
bne bucle
wfi