package editor.algorithm;

import editor.algorithm.logoot.Atom;
import editor.algorithm.logoot.PositionIdentifier;

public abstract class Doc {
    public abstract void insert(int pos,char c);
    public abstract void delete(int pos);
    public abstract void remoteInsert(PositionIdentifier pos,char c);
    public abstract void remoteDelete(PositionIdentifier pos);
}
