package main

import (
	"fmt"
	"io/ioutil"
	"log"

	"github.com/golang/protobuf/jsonpb"
	"github.com/golang/protobuf/proto"
	complexpb "github.com/simplesteph/protobuf-example-go/src/complex"
	enumpb "github.com/simplesteph/protobuf-example-go/src/enum_example"
	simplepb "github.com/simplesteph/protobuf-example-go/src/simple"
)

func doSimple() *simplepb.SimpleMessage {
	sm := simplepb.SimpleMessage{
		Id:         12345,
		IsSimple:   true,
		Name:       "My simple message",
		SampleList: []int32{1, 4, 7, 8},
	}
	fmt.Println(sm)

	sm.Name = "Name is renamed"
	fmt.Println(sm)

	fmt.Println(sm.GetId())
	return &sm
}

func writeToFile(fname string, pb proto.Message) error {
	out, err := proto.Marshal(pb)
	if err != nil {
		log.Fatalln("Can't serialize to bytes", err)
		return err
	}
	if err := ioutil.WriteFile(fname, out, 0644); err != nil {
		log.Fatalln("Can't write to file", err)
		return err
	}
	return nil
}

func readFromFile(fname string, pb proto.Message) error {
	in, err := ioutil.ReadFile(fname)
	if err != nil {
		log.Fatalln("Something went wrong while reading the file", err)
		return err
	}
	if err := proto.Unmarshal(in, pb); err != nil {
		log.Fatalln("Coudn't put bytes into the struct")
		return err
	}
	return nil
}

func readAndWriteDemo(sm proto.Message) {
	writeToFile("simple.bin", sm)
	sm2 := &simplepb.SimpleMessage{}
	readFromFile("simple.bin", sm2)
	fmt.Println(sm2)
}

func toJSON(pb proto.Message) string {
	marshaller := jsonpb.Marshaler{}
	out, err := marshaller.MarshalToString(pb)
	if err != nil {
		log.Fatalln("Can't convert to JSON", err)
		return ""
	}
	return out
}

func fromJSON(in string, pb proto.Message) {
	err := jsonpb.UnmarshalString(in, pb)
	if err != nil {
		log.Fatalln("Couldn't unmarhsal JSON to message", err)
	}
}

func jsonDemo(sm proto.Message) {
	smAsString := toJSON(sm)
	fmt.Println(smAsString)

	sm2 := &simplepb.SimpleMessage{}
	fromJSON(smAsString, sm2)
	fmt.Println("Successfully created proto struct: ", sm2)
}

func doEnum() {
	em := enumpb.EnumMessage{
		Id:           42,
		DayOfTheWeek: enumpb.DayOfTheWeek_MONDAY,
	}
	fmt.Println(em)
}

func doComplex() {
	cm := complexpb.ComplexMessage{
		OneDummy: &complexpb.DummyMessage{
			Id:   1,
			Name: "First Message",
		},
		MultipleDummy: []*complexpb.DummyMessage{
			&complexpb.DummyMessage{
				Id:   2,
				Name: "Second Message",
			},
			&complexpb.DummyMessage{
				Id:   3,
				Name: "Third Message",
			},
		},
	}
	fmt.Println(cm)
}

func main() {
	sm := doSimple()
	readAndWriteDemo(sm)
	jsonDemo(sm)
	doEnum()
	doComplex()
}
