.data
nums: .word 2,100,1000,1,1,725

.text

 ldr r5,=nums
mov r0,#6

bucle:
cmp r0,#0
beq bucle_s
ldr r1,[r5]
push {r1}
add r5,#4
sub r0,#1
b bucle

bucle_s:
wfi

