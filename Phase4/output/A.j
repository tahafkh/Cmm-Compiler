.class A
.super java/lang/Object
.field kir Ljava/lang/Integer;
.field kos Ljava/lang/Boolean;
.field koon LFptr;
.method public <init>()V
.limit stack 128
.limit locals 128
		aload 0
		invokespecial java/lang/Object/<init>()V
		aload 0
		ldc 0
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		putfield A/kir Ljava/lang/Integer;
		aload 0
		ldc 0
		invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;
		putfield A/kos Ljava/lang/Boolean;
		aload 0
		aconst_null
		putfield A/koon LFptr;
		return
.end method
