using System.Collections;

namespace linked_list {
    public class DoubleLinkedList<T> {
        public DoubleLinkedList(T FirstNode) {
            this.Head = new DoubleNode<T> { Next = null, Previous = null, Val = FirstNode };
        }

        private DoubleNode<T> Head { get; }

        public IEnumerator GetEnumerator() {
            DoubleNode<T> tmp = this.Head;
            while (tmp != null) {
                yield return tmp.Val;
                tmp = tmp.Next;
            }
        }

        public void Add(T node) {
            DoubleNode<T> tmp = this.Head;
            while (tmp.Next != null) tmp = tmp.Next;

            tmp.Next = new DoubleNode<T> { Next = null, Previous = tmp, Val = node };
        }
    }
}