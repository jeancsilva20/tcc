
RunWait("regedit /ea BackupFK\origine.reg HKEY_CURRENT_USER\Software\Paint.NET")		;on fait un backup si nécessaire
RunWait("regedit /s BackupFK\PaintNETDEL.reg")											;on importe du vide (= on fait le vide dans la clé)
RunWait("regedit /s BackupFK\PaintNET.reg")												;on importe l'éventuel backup
RunWait("Paint.NET\PaintDotNet.exe", "Paint.NET")										;on lance paint.net
RunWait("regedit /ea BackupFK\new.reg HKEY_CURRENT_USER\Software\Paint.NET")			;on a quitté paint.net, on exporte les nouvelles clés dans new.reg
FileMove(@ScriptDir & "\BackupFK\new.reg", @ScriptDir & "\BackupFK\PaintNET.reg", 1)	;on écrase le backup par new.reg
FileDelete(@ScriptDir & "\BackupFK\new.reg")											;on efface l'export new.reg
RunWait("regedit /s BackupFK\PaintNETDEL.reg")											;on importe du vide (= on fait le vide dans la clé)
RunWait("regedit /s BackupFK\origine.reg")												;on remet les clés d'origine
FileDelete(@ScriptDir & "\BackupFK\origine.reg")										;on efface l'export des clés d'origine
