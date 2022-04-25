	.data
frase: .asciz "Llegados"
mayus: .space 1

	.text
	ldr r5,=frase
	ldr r6,=mayus
	mov r1,#32

bucle:	ldrb r0,[r5]
	cmp r0,#0
	beq fin

	bic r0,r1
	strb r0,[r6]

	add r5,#1
	add r6,#1
	b bucle

fin:	strb r0,[r6]
	wfi