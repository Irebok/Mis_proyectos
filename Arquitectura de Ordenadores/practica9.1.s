.data
pal1: .word 0xAAAAAAAA
pal2: .word 0xBDBDBBAA



.text
ldr r0,=pal1
ldr r1,=pal2
bl interpal
wfi

interpal:
push {r2,r3}
ldr r2,[r0]
ldr r3,[r1]
str r2,[r1]
str r3,[r0]
pop {r2,r3}
mov pc,lr
