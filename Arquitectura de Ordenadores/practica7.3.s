.data
numero: .word 34567
cadena: .space 1

.text
ldr r0,=numero
ldr r0,[r0]
mov r1, #10

mov r5,#0
push {r5}

bucle: bl divide
	add r3,#48
	push {r3}
	cmp r2,#0
	beq sigue
	mov r0,r2
	b bucle

sigue:	ldr r5,=cadena
bucle2:	pop {r0}
	cmp r0,#0
	beq fin
	strb r0,[r5]	
	add r5,#1
	b bucle2	

fin: 	wfi


divide: mov r2,#0
	mov r3,r0
div_bucle: cmp r3,r1
	blt div_fin
	sub r3,r1
	add r2,#1
	b div_bucle

div_fin: mov pc,lr
