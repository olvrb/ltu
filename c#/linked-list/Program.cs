using System;
using System.Text.Json;

namespace linked_list {
    internal class Program {
        private static void Main(string[] args) {
            LinkedList<int> list = new LinkedList<int>(1);
            list.Add(2);
            list.Add(3);

            list.AddAfter(9, 2);

            DoubleLinkedList<int> dlist = new DoubleLinkedList<int>(1);
            dlist.Add(2);
            dlist.Add(3);

            Console.WriteLine(JsonSerializer.Serialize(dlist, new JsonSerializerOptions { MaxDepth = 100 }));

            foreach (int i in dlist) Console.WriteLine(i);
        }
    }
}