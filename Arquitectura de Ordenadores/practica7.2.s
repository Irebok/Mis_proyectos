.text
mov r0, #46
mov r1, #4
bl divide
wfi

divide: mov r2,#0
	mov r3,r0
div_bucle: cmp r3,r1
	blt div_fin
	sub r3,r1
	add r2,#1
	b div_bucle

div_fin: mov pc,lr