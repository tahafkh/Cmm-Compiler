.class Order
.super java/lang/Object
.field quantity Ljava/lang/Integer;
.field product LProductCatalog;
.method public <init>()V
.limit stack 128
.limit locals 128
		aload 0
		aload 0
		ldc 0
		putfield Order/quantity Ljava/lang/Integer;
		aload 0
		new ProductCatalog
		dup
		invokespecial ProductCatalog/<init>()V
		putfield Order/product LProductCatalog;
		return
.end method
