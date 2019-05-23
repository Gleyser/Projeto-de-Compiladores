##  Codigo assembly simples para pascalTests.
	 LD SP, #stackStart 
	 BR main 
bissexto: 
	 BR *0(SP) 
main: 
	 ST a , #10
	 LD R0 , a
	 LD R0 , b
	 ADD R0 , R0 , R0
	 ST a , R0
	 LD R0 , x
	 LD R0 , b
	 SUB R0 , R0 , R0
	 ST a , R0
	 LD R0 , a
	 LD R0 , b
	 DIV R0 , R0 , R0
	 ST a , R0
	 LD R0 , a
	 LD R0 , b
	 MUL R0 , R0 , R0
	 ST a , R0
	 LD R0 , a
	 ST c , 
	 LD R0 , a
	 ST c , 
	 LD R0 , a
	 ST c , 
	 LD R0 , a
	 ST c , 
	 LD R0 , a
	 ST c , 
	 LD R0 , a
	 ST c , 
	 LD R0 , choice
	 LD R0 , isready
	 LD R1 , R0
	 AND R1 , R1 , R0
	 ST c , R1
	 LD R0 , choice
	 LD R0 , isready
	 LD R1 , R0
	 OR R1 , R1 , R0
	 ST c , R1
	 LD R0 , color
	 LD R0 , red
	 ST a , #10
$L1:
	 LD R4 , #20
	 LD R3 , a
	 SUB R0 , R3 , R4
	 BGTZ R0 , $L2
	 LD R3 , a
	 ADD R3 , R3 , #1
	 ST a , R3
	 BR $L1
$L2:
	 HALT 


