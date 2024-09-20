# Mantenha nomes de classes e métodos de bibliotecas usadas
-keep class androidx.** { *; }
-keep class com.google.** { *; }
-keepattributes *Annotation*

# Não faça obfuscation em classes específicas
-keep class com.example.atividade6.** { *; }
