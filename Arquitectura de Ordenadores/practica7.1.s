.data

frase:	.asciz "Hola mundo"
	.balign 4
conv:	.space  1

.text

ldr r5,=frase
mov r0,#0
push {r0}
bucle:	ldrb r0,[r5]
	cmp r0,#0
	beq conti
	push {r0}
	add r5,#1
	b bucle

conti: ldr r5,=conv

bucle2:	pop {r0}
	strb r0,[r5]
	cmp r0,#0	
	beq fin
	add r5,#1
	b bucle2
fin: wfi
	