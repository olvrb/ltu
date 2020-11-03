using System.Collections;

namespace linked_list {
    public class LinkedList<T> : IEnumerable {
        public LinkedList(T FirstNode) {
            this.Head = new Node<T> { Next = null, Val = FirstNode };
        }

        public Node<T> Head { get; }

        public IEnumerator GetEnumerator() {
            Node<T> tmp = this.Head;
            while (tmp != null) {
                yield return tmp.Val;
                tmp = tmp.Next;
            }
        }

        public void Add(T node) {
            Node<T> tmp = this.Head;
            while (tmp.Next != null) tmp = tmp.Next;

            tmp.Next = new Node<T> { Next = null, Val = node };
        }

        public void AddAfter(T add, T after) {
            Node<T> tmp = this.Head;
            while (tmp != null && !tmp.Val.Equals(after)) tmp = tmp.Next;

            tmp.Next = new Node<T> { Next = tmp.Next, Val = add };
        }
    }
}