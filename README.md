# Expression Format Converter

This program means to easily convert expressions between different formats. So the users don't need to spend time on manually changing formats.

Example:
Plain format (e.g. WolframeAlpha, Symbolab): (12+3^2)/4w3
Python: `(12+3**2)/(4*w3)`
LaTeX (e.g. Desmos): `\frac{12+3^2}{4\omega_3}`

For example, if you want to copy an expression from Desmos to WolframeAlpha, you would have to retype the entire expression. But with this program, just copy and paste would suffice.

# Development Log

12 November 2024 α0.0.1
Supports from LaTeX to plain format.
Supports operator `+`,`-`,`*`,`\frac{}{}`.
Supports operand integers.

# Usage

Install Java JDK 23.
At the directory input `java -jar FormulaFormatConverter.jar` and input the LaTeX expression as an argument.
For example
```12+\frac{12}{\frac{1}{1}}```
Output
```(12+(12/(1/1)))```
(Assume correctly formatted)