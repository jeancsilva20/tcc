
RunWait("regedit /ea BackupFK\origine.reg HKEY_CURRENT_USER\Software\Paint.NET")		;on fait un backup si n�cessaire
RunWait("regedit /s BackupFK\PaintNETDEL.reg")											;on importe du vide (= on fait le vide dans la cl�)
RunWait("regedit /s BackupFK\PaintNET.reg")												;on importe l'�ventuel backup
RunWait("Paint.NET\PaintDotNet.exe", "Paint.NET")										;on lance paint.net
RunWait("regedit /ea BackupFK\new.reg HKEY_CURRENT_USER\Software\Paint.NET")			;on a quitt� paint.net, on exporte les nouvelles cl�s dans new.reg
FileMove(@ScriptDir & "\BackupFK\new.reg", @ScriptDir & "\BackupFK\PaintNET.reg", 1)	;on �crase le backup par new.reg
FileDelete(@ScriptDir & "\BackupFK\new.reg")											;on efface l'export new.reg
RunWait("regedit /s BackupFK\PaintNETDEL.reg")											;on importe du vide (= on fait le vide dans la cl�)
RunWait("regedit /s BackupFK\origine.reg")												;on remet les cl�s d'origine
FileDelete(@ScriptDir & "\BackupFK\origine.reg")										;on efface l'export des cl�s d'origine
