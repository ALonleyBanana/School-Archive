/*
** Author: Timothy Victori
** Course: IFT/300
** SQL Server Version: Microsoft SQL server 2022
** OS: Windows 10
** History
** Date Created    Comments
** 02/08/2026      Chapter 5 Assignment Question 4
*/
SELECT a.AccountDescription,
COUNT(a.AccountNo) AS LineItemCount,
SUM(l.InvoiceLineItemAmount) AS LineItemSum
FROM GLAccounts a JOIN InvoiceLineItems l ON a.AccountNo=l.AccountNo
GROUP BY a.AccountDescription
HAVING COUNT(*)>1
ORDER BY LineItemCount DESC
