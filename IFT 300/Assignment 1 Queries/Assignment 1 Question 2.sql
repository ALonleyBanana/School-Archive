/*
** Author: Timothy Victori
** Course: IFT/300
** SQL Server Version: Microsoft SQL server 2022
** OS: Windows 10
** History
** Date Created    Comments
** 01/23/2026      Chapter 3 Assignment Question 2
*/
SELECT 
InvoiceNumber AS Number,
InvoiceTotal AS Total, 
PaymentTotal + CreditTotal AS Credits,
InvoiceTotal - PaymentTotal - CreditTotal AS Balance
FROM Invoices;

