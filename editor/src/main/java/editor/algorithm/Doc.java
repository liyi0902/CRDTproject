package editor.algorithm;

import editor.algorithm.logoot.Atom;
import editor.algorithm.logoot.PositionIdentifier;

public abstract class Doc {
    public abstract Atom localInsert(int pos,char c);
    public abstract PositionIdentifier localDelete(int pos);
    public abstract int remoteInsert(PositionIdentifier pos,char c);
    public abstract int remoteDelete(PositionIdentifier pos);

}
