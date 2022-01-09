.class public Main
.super java/lang/Object
.method public <init>()V
.limit stack 128
.limit locals 128
		aload_0
		invokespecial java/lang/Object/<init>()V
		aload 0
		new java/util/ArrayList
		dup
		invokespecial java/util/ArrayList/<init>()V
		astore 1
		aload 1
		ldc 155
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z
		pop
		aload 1
		ldc 0
		invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;
		invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z
		pop
		aload 1
		ldc 1
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z
		pop
		aload 1
		invokevirtual Fptr/invoke(Ljava/util/ArrayList;)Ljava/lang/Object;
		checkcast java/lang/Integer
		invokevirtual java/lang/Integer/intValue()I
		pop
		return
.end method
.method public static main([Ljava/lang/String;)V
.limit stack 128
.limit locals 128
		new Main
		invokespecial Main/<init>()V
		return
.end method
.method public f(Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/Integer;
.limit stack 128
.limit locals 128
		new List
		dup
		new java/util/ArrayList
		dup
		invokespecial java/util/ArrayList/<init>()V
		invokespecial List/<init>(Ljava/util/ArrayList;)V
		astore 3
		aload 3
		aload 1
		invokevirual List/addElement()I
		aload 3
		aload 2
		invokevirual List/addElement()I
		aload 3
		aload 1
		invokevirual List/addElement()I
		aload 3
		aload 2
		invokevirual List/addElement()I
		aload 3
		aload 2
		invokevirual List/addElement()I
		aload 3
		aload 2
		invokevirual List/addElement()I
		getstatic java/lang/System/out Ljava/io/PrintStream;
		aload 3
		aload 2
		invokevirtual List/getElement(I)Ljava/lang/Object;
		ldc 2
		imul
		aload 3
		aload 2
		ldc 2
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		invokevirtual List/setElement(ILjava/lang/Object;)V
		aload 3
		aload 2
		invokevirtual List/getElement(I)Ljava/lang/Object;
		checkcast java/lang/Integer
		invokevirtual java/lang/Integer/intValue()I
		ldc 13
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		areturn
		return
.end method
.method public g()LFptr;
.limit stack 128
.limit locals 128
		aload 0
		areturn
		return
.end method
.method public h()V
.limit stack 128
.limit locals 128
		return
		return
.end method
.method public r()LFptr;
.limit stack 128
.limit locals 128
		aload 0
		areturn
		return
.end method
.method public m()Ljava/lang/Integer;
.limit stack 128
.limit locals 128
		getstatic java/lang/System/out Ljava/io/PrintStream;
		ldc 1400
		invokevirtual java/io/PrintStream/println(I)V
		ldc 15
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		areturn
		return
.end method
.method public j(Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/Integer;
.limit stack 128
.limit locals 128
		getstatic java/lang/System/out Ljava/io/PrintStream;
		aload 1
		getstatic java/lang/System/out Ljava/io/PrintStream;
		aload 0
		new java/util/ArrayList
		dup
		invokespecial java/util/ArrayList/<init>()V
		astore 3
		aload 3
		ldc 20
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z
		pop
		aload 3
		ldc 1
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z
		pop
		aload 3
		invokevirtual Fptr/invoke(Ljava/util/ArrayList;)Ljava/lang/Object;
		checkcast java/lang/Integer
		invokevirtual java/lang/Integer/intValue()I
		invokevirtual java/io/PrintStream/println(I)V
		ldc 1
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		areturn
		return
.end method
.method public k(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;)Ljava/lang/Integer;
.limit stack 128
.limit locals 128
		aload 0
		new java/util/ArrayList
		dup
		invokespecial java/util/ArrayList/<init>()V
		astore 4
		aload 4
		invokevirtual Fptr/invoke(Ljava/util/ArrayList;)Ljava/lang/Object;
		pop
		aload 0
		new java/util/ArrayList
		dup
		invokespecial java/util/ArrayList/<init>()V
		astore 6
		aload 6
		invokevirtual Fptr/invoke(Ljava/util/ArrayList;)Ljava/lang/Object;
		checkcast Fptr
		new java/util/ArrayList
		dup
		invokespecial java/util/ArrayList/<init>()V
		astore 5
		aload 5
		aload 1
		invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z
		pop
		aload 5
		ldc 2
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z
		pop
		aload 5
		invokevirtual Fptr/invoke(Ljava/util/ArrayList;)Ljava/lang/Object;
		checkcast java/lang/Integer
		invokevirtual java/lang/Integer/intValue()I
		pop
		aload 2
		ifeq Label_0
		aload 3
		areturn
		goto Label_1
	Label_0:
		getstatic java/lang/System/out Ljava/io/PrintStream;
		aload 0
		new java/util/ArrayList
		dup
		invokespecial java/util/ArrayList/<init>()V
		astore 7
		aload 7
		aload 3
		invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z
		pop
		aload 7
		aload 3
		invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z
		pop
		aload 7
		invokevirtual Fptr/invoke(Ljava/util/ArrayList;)Ljava/lang/Object;
		checkcast java/lang/Integer
		invokevirtual java/lang/Integer/intValue()I
		invokevirtual java/io/PrintStream/println(I)V
	Label_1:
		aload 0
		new java/util/ArrayList
		dup
		invokespecial java/util/ArrayList/<init>()V
		astore 9
		aload 9
		invokevirtual Fptr/invoke(Ljava/util/ArrayList;)Ljava/lang/Object;
		checkcast Fptr
		new java/util/ArrayList
		dup
		invokespecial java/util/ArrayList/<init>()V
		astore 8
		aload 8
		invokevirtual Fptr/invoke(Ljava/util/ArrayList;)Ljava/lang/Object;
		checkcast java/lang/Integer
		invokevirtual java/lang/Integer/intValue()I
		pop
		ldc 2
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		areturn
		return
.end method
