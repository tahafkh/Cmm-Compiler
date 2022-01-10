.class public Main
.super java/lang/Object
.method public <init>()V
.limit stack 128
.limit locals 128
		aload_0
		invokespecial java/lang/Object/<init>()V
		new List
		dup
		new java/util/ArrayList
		dup
		invokespecial java/util/ArrayList/<init>()V
		invokespecial List/<init>(Ljava/util/ArrayList;)V
		astore 1
		aload 1
		new Fptr
		dup
		aload_0
		ldc "ff"
		invokespecial Fptr/<init>(Ljava/lang/Object;Ljava/lang/String;)V
		invokevirtual List/addElement(Ljava/lang/Object;)V
		aload 1
		ldc 0
		invokevirtual List/getElement(I)Ljava/lang/Object;
		checkcast Fptr
		astore 2
		aload 2
		new java/util/ArrayList
		dup
		invokespecial java/util/ArrayList/<init>()V
		astore 4
		aload 4
		ldc 2
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z
		pop
		aload 4
		ldc 3
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z
		pop
		aload 4
		invokevirtual Fptr/invoke(Ljava/util/ArrayList;)Ljava/lang/Object;
		checkcast A
		getfield A/kir Ljava/lang/Integer;
		checkcast java/lang/Integer
		invokevirtual java/lang/Integer/intValue()I
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		astore 3
		getstatic java/lang/System/out Ljava/io/PrintStream;
		aload 3
		invokevirtual java/lang/Integer/intValue()I
		invokevirtual java/io/PrintStream/println(I)V
		return
.end method
.method public static main([Ljava/lang/String;)V
.limit stack 128
.limit locals 128
		new Main
		invokespecial Main/<init>()V
		return
.end method
.method public ff(Ljava/lang/Integer;Ljava/lang/Integer;)LA;
.limit stack 128
.limit locals 128
		new A
		dup
		invokespecial A/<init>()V
		astore 3
		aload 3
		ldc 12
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		putfield A/kir Ljava/lang/Integer;
		aload 3
		getfield A/kir Ljava/lang/Integer;
		invokevirtual java/lang/Integer/intValue()I
		pop
		aload 3
		iconst_1
		invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;
		putfield A/kos Ljava/lang/Boolean;
		aload 3
		getfield A/kos Ljava/lang/Boolean;
		invokevirtual java/lang/Boolean/booleanValue()Z
		pop
		aload 3
		areturn
.end method
