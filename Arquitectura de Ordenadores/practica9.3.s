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
bl ordena


ldr r5,=nums
mov r0,#6

bucle2:
cmp r0,#0
beq fin
pop {r1}
str r1,[r5]
add r5,#4
sub r0,#1
b bucle2

fin:
wfi

ordena:
push {r0-r7,lr}
mov r2,#1

for1: 
cmp r2,#6
bge o_fin
mov r3,#0

	for2:
	cmp r3,#5
	bge for1f
		
		mov r0,#4
		mul r0,r3
		add r0,sp	
		add r0,#36
		mov r1,r0
		add r1,#4
		ldr r4,[r0]
		ldr r5,[r1]
		cmp r4,r5
		blt for2
		bl interpal

for2f: 	
	add r3,#1
	b for2

for1f: 
add r2,#1
b for1

o_fin: pop {r0-r7,pc}

interpal:
push {r2,r3}
ldr r2,[r0]
ldr r3,[r1]
str r2,[r1]
str r3,[r0]
pop {r2,r3}
mov pc,lr


.end
